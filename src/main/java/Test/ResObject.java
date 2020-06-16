package Test;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author pan
 * @Date 2020/5/9 14:30
 * @Description
 * @Version 1.0
 **/
@Data
public class ResObject implements Serializable {
    /**
     * 属性值列表
     * Key: 属性编码， value：属性值对象
     */
    private LinkedHashMap<String, AttributeValue> attrValues = new LinkedHashMap<>();

    public Map<String, AttributeValue> getAttrValues() {
        return attrValues; // 返回可修改的对象
    }
}
