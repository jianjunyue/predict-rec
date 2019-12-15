package enumTest;

import java.util.Arrays;

public enum HotSaleItemTag {
    BOUGHT("你常吃", 4),

    POPULARITY("人气", 1),

    KOUBEI("好评", 2),

    LIKE("你的菜", 3);

    private String tagDesc;

    private int tagCode;

    HotSaleItemTag(String tagDesc, int tagCode) {
        this.tagDesc = tagDesc;
        this.tagCode = tagCode;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public int getTagCode() {
        return tagCode;
    }

    public static HotSaleItemTag getItemTag(int code) {
        return Arrays.stream(HotSaleItemTag.values()).filter(tag -> tag.getTagCode() == code)
                .findFirst()
                .orElse(null);
    }
}
