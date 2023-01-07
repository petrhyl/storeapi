package dev.store.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "addresses")
public class Address
{	
	public Address(){}
	
	public Address(int number, String street, String postcode)
	{
		super();
		this.number = number;
		this.street = street;
		this.postcode = postcode;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //anotace rika, ze id bude vytvoreno samotnou databazi
	private int id;	
	// muze se pouzit anotace @Column(name = "") k tomu aby compilator vedel, ze dana datova slozka odpovida urcitemu sloupci v tabulce
	@NotNull(message = "house number must not be null")
	private int number;
	@NotBlank
	private String street;
	@NotNull
//	@Pattern(regexp = "^\\d{3} ?\\d{2}$",message = "invalid postcode number) - regularni vyraz pro kontrolu ceskeho PSC (kvuli stringu tam jsou navic zpetna lomitka)
	private String postcode;
	
	public int getId()
	{
		return id;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getPostcode()
	{
		return postcode;
	}
	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}
	
}
