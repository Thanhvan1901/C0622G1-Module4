package translate.service.impl;

import org.springframework.stereotype.Service;
import translate.model.Translate;
import translate.service.ITranslateService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TranslateService implements ITranslateService {
    private static Map<Integer, Translate> dictionaryMap = new HashMap<>();

    static {
        dictionaryMap.put(1, new Translate("hello", "Xin Chào"));
        dictionaryMap.put(2, new Translate("one", "Một"));
        dictionaryMap.put(3, new Translate("birthday", "Sinh Nhật "));
        dictionaryMap.put(4, new Translate("computer", "Máy Tính"));
        dictionaryMap.put(5, new Translate("mouse", "Con Chuột"));
        dictionaryMap.put(6, new Translate("phone", "Điện Thoại"));
    }

    @Override
    public List<Translate> findAll() {
        return new ArrayList<>(dictionaryMap.values());
    }
}
