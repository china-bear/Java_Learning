/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package java8_features.book_learning.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Domain class for a popular music artist.
 * <p>
 * 创作音乐的个人或团队
 *
 * @author Richard Warburton
 */
public final class Artist {

    private String name;            // 艺术家的名字
    private List<Artist> members;   // 乐队成员
    private String nationality;     // 乐队来自哪里

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the members
     */
    public Stream<Artist> getMembers() {
        return members.stream();
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    public boolean isSolo() {
        return members.isEmpty();
    }

    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy() {
        List<Artist> members = getMembers().map(Artist::copy).collect(toList());
        return new Artist(name, members, nationality);
    }

}
