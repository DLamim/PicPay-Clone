package br.com.dlm.picpayclone.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class ResourceBase<T> {

    protected ResponseEntity<T> responseItemCreated(T object) {
        return ResponseEntity.status(HttpStatus.CREATED).body(object);
    }

    protected  ResponseEntity<T> responseItemCreatedURI(T object, UriComponentsBuilder uriBuilder, String path, String code) {
        URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).body(object);
    }

    protected ResponseEntity<T> responderItemNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> responseSuccess() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<T> responseSuccessWithItem(T object) {
        return ResponseEntity.status(HttpStatus.OK).body(object);
    }

    protected ResponseEntity<List<T>> responseEmptyList() {
        List<T> emptyList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(emptyList);
    }

    protected ResponseEntity<List<T>> responseListOfItems(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    protected ResponseEntity<T> responseBadResquest() {
        return ResponseEntity.badRequest().build();
    }
}
