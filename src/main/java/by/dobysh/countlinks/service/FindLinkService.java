package by.dobysh.countlinks.service;

import by.dobysh.countlinks.model.Link;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FindLinkService {

    public List<Link> getLinks(String url) throws IOException;

}
