package com.controller;

import com.model.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {
	static HashMap<Integer, Book> Books = new HashMap<Integer, Book>();
	
	@RequestMapping(value="/display/{id}", method=RequestMethod.GET)
	public String getBook(@PathVariable int id) {
		Book b = null;
		if(Books.containsKey(id)) 
		{
			b = Books.get(id);
		}
		return b.toString();
	}
	@RequestMapping(value="/display_all", method=RequestMethod.GET)
	public String getAllBooks()
	{
		String dip = " ";
		if(!Books.isEmpty()) 
		{
			for (Map.Entry me: Books.entrySet())
				{
					dip = dip + "\n" + me.getValue().toString();
				}
		}
		else
		{
			dip = "No Books";
		}
		return dip;
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<String> insert(@RequestParam ("id") int id, @RequestParam ("name") String name,@RequestParam ("author") String author,@RequestParam ("publisher") String publisher)
	{
		if(!Books.containsKey(id))
		{
			Books.put(id, new Book(id, name, author, publisher));
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.ALREADY_REPORTED);
		}
	}
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam ("id") int id)
	{
		if(!Books.containsKey(id))
		{
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			Books.remove(id);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
	}
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@RequestParam ("id") int id, @RequestParam ("name") String name,@RequestParam ("author") String author,@RequestParam ("publisher") String publisher)
	{
		if(!Books.containsKey(id))
		{
			Books.get(id).setName(name);
			Books.get(id).setAuthor(author);
			Books.get(id).setPublisher(publisher);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
}
