package love.iloveworld.buffmoitor.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping("/")
    public String index(Model model) throws InterruptedException {

        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=34066&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695388861518",
                "34066","name1","wear1", "stram1", "buff1", "e1");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=835624&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695392947213",
                "835624","name2","wear2", "stram2", "buff2", "e2");

        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=835624&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695392947213",
                "835624","name3","wear3", "stram3", "buff3", "e3");

        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=871916&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695394432367",
                "871916","name4","wear4", "stram4", "buff4", "e4");

        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=35355&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393566152",
                "35355","name5","wear5", "stram5", "buff5", "e5");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=871970&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393645624",
                "871970","name6","wear6", "stram6", "buff6", "e6");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=872000&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393699179",
                "872000","name7","wear7", "stram7", "buff7", "e7");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=45462&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695394286482",
                "45462","name8","wear8", "stram8", "buff8", "e8");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=763250&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393772653",
                "763250","name9","wear9", "stram9", "buff9", "e9");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=781534&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393824096",
                "781534","name10","wear10", "stram10", "buff10", "e10");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=900464&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393845966",
                "900464","name11","wear11", "stram11", "buff11", "e11");
        getItem1(model,"https://buff.163.com/api/market/goods/sell_order?game=csgo&goods_id=33976&page_num=1&sort_by=default&mode=&allow_tradable_cooldown=1&_=1695393876715",
                "33976","name12","wear12", "stram12", "buff12", "e12");




        return "index";
    }

    private static void getItem1(Model model, String url, String id, String name, String wear, String steam, String buff, String e5) throws InterruptedException {
        Thread.sleep(400);
        String str = HttpUtil.get(url);
        Object data = JSONUtil.parseObj(str).get("data");


        Object item = JSONUtil.parseObj(data).getJSONArray("items").get(0);
        model.addAttribute(name, JSONUtil.parseObj(JSONUtil.parseObj(JSONUtil.parseObj(data).get("goods_infos")).get(id)).get("name"));
        model.addAttribute(wear, "磨损度: "+JSONUtil.parseObj(JSONUtil.parseObj(item).get("asset_info")).get("paintwear"));
        model.addAttribute(steam, JSONUtil.parseObj(JSONUtil.parseObj(JSONUtil.parseObj(data).get("goods_infos")).get("34066")).get("steam_price"));
        model.addAttribute(buff, JSONUtil.parseObj(item).get("price"));
        model.addAttribute(e5, "敬请期待");
    }
}
