package cn.tedu.ttms.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.ttms.base.entity.PageObject;
import cn.tedu.ttms.sys.entity.Dictionary;
import cn.tedu.ttms.sys.entity.DictionaryType;
import cn.tedu.ttms.sys.mapper.DictionaryMapper;
import cn.tedu.ttms.sys.service.DictionaryService;


@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
	@Resource
	private DictionaryMapper dictMapper;

	public List<DictionaryType> selectDictType(DictionaryType dictType, PageObject pageObj) throws Exception {
		return dictMapper.selectDictType(dictType, pageObj);
	}

	public int getDictTypeCount(DictionaryType dictType) throws Exception {
		return dictMapper.getDictTypeCount(dictType);
	}

	public String getMaxDictTypeId() throws Exception {
		return dictMapper.getMaxDictTypeId();
	}

	public int addDictType(DictionaryType dictType) throws Exception {
		return dictMapper.addDictType(dictType);
	}

	public int updateDictType(DictionaryType dictType) throws Exception {
		return dictMapper.updateDictType(dictType);
	}

	public int delDictType(String dictTypeId) throws Exception {
		Dictionary dict = new Dictionary();
		dict.setDictTypeId(dictTypeId);
		this.delDictionary(dict);
		return dictMapper.delDictType(dictTypeId);
	}

	public List<Dictionary> selectDictonary(Dictionary dict) throws Exception {
		return dictMapper.selectDictonary(dict);
	}

	public int getDictionaryCount(Dictionary dict) throws Exception {
		return dictMapper.getDictionaryCount(dict);
	}

	public int addDictionary(Dictionary dict) throws Exception {
		return dictMapper.addDictionary(dict);
	}

	public int updateDictionary(Dictionary dict) throws Exception {
		return dictMapper.updateDictionary(dict);
	}

	public int delDictionary(Dictionary dict) throws Exception {
		return dictMapper.delDictionary(dict);
	}
}
