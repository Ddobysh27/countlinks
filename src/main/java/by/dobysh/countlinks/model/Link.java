package by.dobysh.countlinks.model;

import java.util.Objects;

/**
 * Класс ссылка со свойствами <b>id</b>, <b>name</b> и <b>address</b>.
 * @autor Добыш Дмитрий
 * @version 1.0
 */
public class Link {

    /** Поле идентификатор*/
    private int id;

    /** Поле имя*/
    private String name;

    /**Поле веб-адрес*/
    private String address;

    /**
     * Конструктор - создание нового объекта
     * @see Link#Link(int, String, String)
     */
    public Link() {
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - производитель
     * @param name - цена
     * @param address - веб-адрес
     * @see Link#Link()
     */
    public Link(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * Метод получения значения поля {@link Link#id}
     * @return возвращает идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Метод установки значения идентификатора {@link Link#id}
     * @param id - идентификатор
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Метод получения значения поля {@link Link#name}
     * @return возвращает имя
     */
    public String getName() {
        return name;
    }

    /**
     *  Метод установки значения имени {@link Link#name}
     * @param name - имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод получения значения поля {@link Link#address}
     * @return возвращает веб-адрес
     */
    public String getAddress() {
        return address;
    }

    /**
     *  Метод установки значения веб-адреса {@link Link#address}
     * @param address - веб-адрес
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;
        Link link = (Link) o;
        return getId() == link.getId() &&
                Objects.equals(getName(), link.getName()) &&
                Objects.equals(getAddress(), link.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAddress());
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
