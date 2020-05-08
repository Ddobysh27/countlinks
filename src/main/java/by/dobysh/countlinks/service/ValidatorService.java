package by.dobysh.countlinks.service;

import org.springframework.stereotype.Service;

@Service
public interface ValidatorService {
    boolean checkURL(String testURL);
}
