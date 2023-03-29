package dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class BankAccount {
@Id
@GeneratedValue(generator = "accNo")
@SequenceGenerator(initialValue = 456987451,allocationSize = 1,sequenceName = "accNo",name = "accNo")
long accNo;
String type;
double amount;
boolean status;
double accLimit;

@ManyToOne
Customer customer;

@OneToMany(cascade = CascadeType.ALL)
List<BankTransaction> bankTransactions;

	
}
