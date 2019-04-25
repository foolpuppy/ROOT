package top.wigon.DAO;

/**
 * @author L
 * @version 1.0
 * @date 2019/4/25 9:48
 **/
public interface  BaseDAO<T> {
    /**
     * 通过实体查找，返回该实体
     * @return
     */
     T findByEntity(T t);

    /**
     * 插入实体
     * @return
     */
     Boolean insertEntity(T t);

}
