package rca.ne.client.controllers;

import com.sun.xml.txw2.Document;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import org.springframework.web.client.RestTemplate;
import rca.ne.client.dtos.CreateOrUpdateLinkDTO;

@Controller
@RequestMapping("/")
public class DownloadController {

    @GetMapping
    public String index() {
        return  "Download";
//        return "AllWebsites";
    }
    @GetMapping("/All-WebSites")
    public String allWebsites(){
        return "AllWebsites";
    }

    public static void downloadFile(URL url, String outputFileName) throws IOException    {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    @PostMapping("/download")
    public String download(String url, String name, long start_time, long end_time, long elapse_time,int kilobytes) throws IOException {
//        String urlGetter = "https://www.baeldung.com/domain";
        CreateOrUpdateLinkDTO dto = new CreateOrUpdateLinkDTO(url, name,  start_time,  end_time,  elapse_time, kilobytes);
        String urlGetter = dto.getUrl();
        String domainName =  urlGetter.replaceAll("http(s)?://|www\\.|/.*", "");
        System.out.println(domainName);
        String path = "/home/rca/Documents/" + domainName;
        System.out.println(path);
        File theDir = new File(path);
        if (!theDir.exists()){
            theDir.mkdirs();
        }
        URL downloadUrl = new URL(url);
        String pageWriterPath = path + "/index.html";
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(downloadUrl.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(pageWriterPath));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Page downloaded.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URLConnection conn = downloadUrl.openConnection();
        int size = conn.getContentLength();

        if(size < 0){
            System.out.println(size);
        }else{
            System.out.println("no file");
        }
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        dto.setName(domainName);
        dto.setStart_time(startTime);
        dto.setEnd_time(endTime);
        dto.setElapse_time(duration);
        dto.setKilobytes(size);

        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForObject("http://localhost:8500/api/websites",dto,CreateOrUpdateLinkDTO.class);

        
//        Document doc = Jsoup.parse(pageWriterPath, "UTF-8", "http://example.com/");

        return "redirect:/All-WebSites";
    }
}

