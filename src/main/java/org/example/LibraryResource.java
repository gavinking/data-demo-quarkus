package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import java.util.List;

@Path("/")
public class LibraryResource {

    @Inject Library library;

    @GET
    @Path("/book/{isbn}")
    public Book byIsbn(@PathParam String isbn) {
        return library.byIsbn(isbn).orElseThrow();
    }

    @GET
    @Path("/title/{title}")
    public List<Book> byTitle(@PathParam String title) {
        String pattern = '%' + title.replace('*', '%') + '%';
        return library.byTitle(pattern);
    }

    @POST
    @Path("/new")
    public String create(Book book) {
        library.add(book);
        return "Added " + book.isbn;
    }

    @POST
    @Path("/delete/{isbn}")
//    @Transactional
    public String delete(@PathParam String isbn) {
        library.delete(isbn);
        return "Deleted " + isbn;
    }
}
