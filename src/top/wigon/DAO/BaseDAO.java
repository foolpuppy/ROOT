package top.wigon.DAO;

import java.util.Map;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:48
 **/
public interface BaseDAO<T> {
    /**
     * 通过实体查找，返回该实体
     *
     * @param t
     * @return T
     */
    T findByEntity(T t);

    /**
     * 插入实体
     *
     * @return
     */
    Boolean addEntity(T t);

    /**
     * 添加实体
     *
     * @param t
     * @return
     */
    boolean updateEntity(T t);

    /**
     * 删除实体
     *
     * @param t
     * @return
     */
    boolean deleteEntity(T t);

    /**
     * 获取插入值的map
     *
     * @param t
     * @return
     */
    Map<String, Object> getValMap(T t);

    /**
     * 获得位移ID
     *
     * @param t
     * @return
     */
    Map<String, Object> getPrimaryKey(T t);

}
