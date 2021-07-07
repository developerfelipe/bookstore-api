package com.felipefreitas.BookstoreAPI.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String isbnNumber;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "launch_year")
	private int launchYear;
	
	@Column(name = "page_count")
	private int pageCount;
	
	@Column(name = "price")
	private float price;
	
	@Column(name="book_format")
	private String bookFormat;
	
	@Column(name="language")
	private String language;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name = "isReserved")
	private boolean isReserved;

	public Book() {
		super();
	}
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public Book(String isbnNumber, String title, String author, String publisher, int launchYear, int pageCount,
			float price, String bookFormat, String language, String weight, String genre ) {
		super();
		this.isbnNumber = isbnNumber;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.launchYear = launchYear;
		this.pageCount = pageCount;
		this.price = price;
		this.bookFormat = bookFormat;
		this.language = language;
		this.weight = weight;
		this.genre = genre;
		this.isReserved = false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsbnNumber() {
		return isbnNumber;
	}

	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getLaunchYear() {
		return launchYear;
	}

	public void setLaunchYear(int launchYear) {
		this.launchYear = launchYear;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(String bookFormat) {
		this.bookFormat = bookFormat;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookFormat == null) ? 0 : bookFormat.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((isbnNumber == null) ? 0 : isbnNumber.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + launchYear;
		result = prime * result + pageCount;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookFormat == null) {
			if (other.bookFormat != null)
				return false;
		} else if (!bookFormat.equals(other.bookFormat))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (isbnNumber == null) {
			if (other.isbnNumber != null)
				return false;
		} else if (!isbnNumber.equals(other.isbnNumber))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (launchYear != other.launchYear)
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
	
	
}
