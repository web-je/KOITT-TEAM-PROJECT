package koitt.ratta.doeat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import koitt.ratta.doeat.domain.GalleryVo;

public interface GalleryService {

	List<GalleryVo> viewAll();

}
