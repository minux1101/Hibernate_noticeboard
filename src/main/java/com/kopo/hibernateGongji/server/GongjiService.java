package com.kopo.hibernateGongji.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kopo.hibernateGongji.dao.GongjiDAO;
import com.kopo.hibernateGongji.model.Gongji;

@Service("gongjiService")
public class GongjiService {

	@Autowired
	GongjiDAO gongjiDao;

	@Transactional
	public List<Gongji> selectAll() {
		List<Gongji> gongjiAsc = gongjiDao.selectAll();
		List<Gongji> gongjiDesc = new ArrayList<>();

		for (int i = 0; i < gongjiAsc.size(); i++) {
			gongjiDesc.add(gongjiAsc.get(gongjiAsc.size() - (i + 1)));
		}

		return gongjiDesc;
	}

	@Transactional
	public Gongji selectOne(int id) {
		return gongjiDao.selectOne(id);
	}

	@Transactional
	public void insert(Gongji gongji) {
		gongjiDao.insert(gongji);
	}

	@Transactional
	public void update(Gongji gongji) {
		gongjiDao.update(gongji);

	}

	@Transactional
	public void delete(int id) {
		gongjiDao.delete(id);
	}
}
