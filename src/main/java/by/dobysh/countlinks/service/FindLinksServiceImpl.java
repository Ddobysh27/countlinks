package by.dobysh.countlinks.service;

import by.dobysh.countlinks.model.Link;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindLinksServiceImpl implements FindLinkService {

    public List<Link> getLinks(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();

        List<Link> foundListLink = new ArrayList<>();

        Elements links = doc.select("a[href]");

        int countLink = 0;

        for (Element link : links) {
            countLink++;
            foundListLink.add(new Link(countLink, link.text(),  link.attr("abs:href")));
        }

        return foundListLink;
    }

}
