package koitt.ratta.doeat.service;

import java.util.List;
import java.util.Map;

import koitt.ratta.doeat.domain.GalleryListVo;

public interface FilterService {

	List<GalleryListVo> changeFilter(Map<String, String[]> types, int loginUIdx);

}
