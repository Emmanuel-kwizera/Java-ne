package rca.ne.client.controllers;

import com.sun.xml.txw2.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;


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
    public String download(String url) throws MalformedURLException {
//        String urlGetter = "https://www.baeldung.com/domain";
        CreateOrUpdateLinkDTO dto = new CreateOrUpdateLinkDTO(url);
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
//        Document doc = Jsoup.parse(pageWriterPath, "UTF-8", "http://example.com/");

        return "redirect:/All-WebSites";
    }
}

