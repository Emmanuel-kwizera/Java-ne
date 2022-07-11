package rca.ne.client.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import rca.ne.client.dtos.CreateOrUpdateLinkDTO;

import java.io.File;

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
    public String download(String url){
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

        return "redirect:/All-WebSites";
    }
}

