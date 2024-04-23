package com.uy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uy.mapper.CharactersMapper;
import com.uy.pojo.Characters;
import com.uy.service.CharactesServices;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CharactesServicesImpl extends ServiceImpl<CharactersMapper,Characters>
implements CharactesServices {

    //获取爬取网页地址
    @Value("${charactsUrl}")
    private String charactsUrl;

    public Map<String,String> getCharacterInfo(Characters characterInfo){
        Map<String,String> result = new HashMap<String,String>();

        String character = characterInfo.getChar_name();

        try {
            String url = charactsUrl + "&query="+character+"&wd="+character;
            Document document = Jsoup.connect(url).get();
            Element element = document.getElementById("header-img").getElementById("word_bishun");

            //动态图片汉字书写
            String dataGif = element.attr("data-gif");
            //            System.out.println("dataGif:"+dataGif);

//            Element characterElement = document.getElementById("header-detail").getElementById("header-list");
            String pinYin = document.getElementById("pinyin").select("span").get(0).select("b").get(0).text();

            //            System.out.println("pinYin:"+pinYin);



//            Elements elements = document.getAllElements();
//            System.o ut.println(element);
//            System.out.println(document.outerHtml());


        }catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}
