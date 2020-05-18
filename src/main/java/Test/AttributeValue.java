package Test;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author pan
 * @Date 2020/5/9 14:31
 * @Description
 * @Version 1.0
 **/
@Data
public class AttributeValue {

    public enum ValueType {
        U, O
    }

    /**
     * 当前属性值
     */
    private Serializable value;

    /**
     * 当前属性值类型，
     */
    private ValueType valueType;
}
