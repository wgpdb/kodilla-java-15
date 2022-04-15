package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given & When
        Library library = new Library("The Library");

        IntStream.iterate(1, n -> n + 1)
                .limit(4)
                .forEach(n -> library.getBooks().add(new Book("Book " + n, "Author of book " + n,
                        LocalDate.now().minusYears(n))));

        Library libraryShallowClone = null;
        try {
            libraryShallowClone = library.shallowCopy();
            libraryShallowClone.setName("The Shallow Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library libraryDeepClone = null;
        try {
            libraryDeepClone = library.deepCopy();
            libraryDeepClone.setName("The Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        System.out.println(library);

        System.out.println(libraryShallowClone);
        assertEquals(libraryShallowClone.getBooks(), library.getBooks());

        System.out.println(libraryDeepClone);
        assertNotEquals(libraryDeepClone.getBooks(), library.getBooks());
    }
}