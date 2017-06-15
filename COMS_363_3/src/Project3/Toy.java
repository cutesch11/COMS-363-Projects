package Project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Toy {

	public static void main(String[] args) throws FileNotFoundException,Exception {
		insert("xyz.tb");
	}
	
	public static void writetoFile(String filename, Table tab) throws FileNotFoundException{
		
		try{
			
			PrintWriter p = new PrintWriter(filename);
			p.println(tab.header);
			
			
			for(int i = 0; i < tab.record.length; ++i){
				p.print("{");
				for(int j = 0; j < tab.record[i].value.length; ++j){
					p.print(tab.record[i].value[j]);
					
					if(j != tab.record[i].value.length-1){
						p.print("|");
					}
					else{}
				}
				
				p.println("}");
			}
			p.close();
		}
		
		catch(FileNotFoundException e){
			System.out.println("File doesn't exist");
		}
	}
	
	public static Table readfromFile(String filename) throws FileNotFoundException{
		
		Scanner s = new Scanner(new File(filename));
		
		s.useDelimiter("]");
		String att = s.next().substring(1);
		int numatts = Integer.parseInt(att);
		ArrayList<Attribute> atts = new ArrayList<Attribute>();
		
		for(int i = 0; i < numatts; ++i){ // populate attribute array
			String attSt = s.next().substring(1);
			Scanner t = new Scanner(attSt);
			t.useDelimiter(":");
			String attname = t.next();
			int attType = t.nextInt();
			atts.add(new Attribute(attname, attType));
			t.close();
		}
		
		int numRec = Integer.parseInt(s.next().substring(1));
		Record[] r = new Record[numRec];
		s.nextLine();
		s.useDelimiter("}");
		
		for(int i = 0; i < numRec; ++i){ // populate records array
			Record rec = new Record(numatts);
			String specs = s.next().substring(1);
			Scanner rScan = new Scanner(specs);
			rScan.useDelimiter("\\|");
			for(int j = 0; j < numatts; ++j){
				rec.value[j] = rScan.next();
			}
			rScan.close();
			r[i] = rec;
			s.nextLine();
		}
		s.close();
		
		return new Table(atts,r);
	}
	
	public static void create(String filename) throws FileNotFoundException{
		Scanner s = new Scanner(System.in);
		ArrayList<Attribute> atts = new ArrayList<Attribute>();
		String response = "y";
		
		while(response.charAt(0) == 'y'){
		
		//Record name of current attribute
		System.out.println("Attribute name:");
		String Aname = s.next();
		
		//Record type of current attribute
		System.out.println("Select a type: 1. integer; 2. double; 3. boolean; 4. string ");
		int Atype = s.nextInt();
		
		//Prompt for more input
		System.out.println("More attribute? (y/n)");
		response = s.next();
		
		
		atts.add(new Attribute(Aname, Atype));
		
		}
		s.close();

		Table t = new Table(atts, new Record[0]);
		writetoFile(filename, t);

		
	}
	
	
	public static void displayHeader(String filename) throws FileNotFoundException{

		
		Table t = readfromFile(filename);
		
		System.out.println(t.numberOfAttributes + " attributes");
		int attNum = 1;
		
		for(int i = 0; i < t.numberOfAttributes; ++i){
			
			System.out.print("Attribute " + attNum + ": " + t.attribute[i].name + ",");
			
			if(t.attribute[i].type == 1){
				System.out.println(" integer");
			}
			
			else if(t.attribute[i].type == 2){
				System.out.println(" double");
			}
			
			else if(t.attribute[i].type == 3){
				System.out.println(" boolean");
			}
			
			else if(t.attribute[i].type == 4){
				System.out.println(" String");
			}
			attNum += 1;
		}
		System.out.println(t.record.length + " records");
		
	}
	
	public static void insert(String filename) throws Exception{
		
		try{
			
			Table t = readfromFile(filename);
			Scanner s = new Scanner(System.in);
			Record r = new Record(t.numberOfAttributes);
			
			for(int i = 0; i < t.numberOfAttributes; ++i){
				System.out.println(t.attribute[i].name + ":");
				
				if(t.attribute[i].type == 1){
					try{
						int input = s.nextInt();
						String in = Integer.toString(input);
						r.value[i] = in;
					}
					catch(InputMismatchException e){
						System.out.println("Input error");
						return;
					}
				}
				
				else if(t.attribute[i].type == 2){
					try{
						double input = s.nextDouble();
						r.value[i] = Double.toString(input);
					}
					catch(InputMismatchException e){
						System.out.println("Input error");
						return;

					}
				}
				
				else if(t.attribute[i].type == 3){
					
					try{
						String input = s.next();
						r.value[i] = input;
						
						if(input.charAt(0) != 'T' && input.charAt(0) != 'F'){
							throw new Exception("Input error");
						}
					}
					catch(InputMismatchException e){
						System.out.println("Input error");
						return;

					}
	
				}
				
				else if(t.attribute[i].type == 4){
					try{
						String input = s.next();
						r.value[i] = input;
					}
					catch(InputMismatchException e){
						System.out.println("Input error");
						return;
					}
				}

			}
			t.addNewRecord(r);
			writetoFile(filename, t);
		}
		
		catch(FileNotFoundException f){
			System.out.println("File doesn't exist");
		}
		

		
	}
	
	public static void displayRec(int index, String filename) throws FileNotFoundException{
		Table t = readfromFile(filename);
		
		for(int i = 0; i < t.numberOfAttributes; ++i){
			System.out.println(t.attribute[i].name + ": " + t.record[index].value[i]);
		}
	}

	
	public static void deleteRec(int index, String filename) throws FileNotFoundException{
		Table t = readfromFile(filename);
		t.removeRecord(index);
		writetoFile(filename,t);
	}

	
	public static void searchRec(String condition, String filename) throws FileNotFoundException{
		Table t = readfromFile(filename);
		
		Scanner s = new Scanner(condition);
		String attName = s.next();
		//skip over equals sign
		s.next();

		for(int i = 0; i < t.attribute.length; ++i){
			if(attName.compareTo(t.attribute[i].name) == 0){
				if(t.attribute[i].type == 1){
					int cond = s.nextInt();
					boolean found = false;
					
					for(int j = 0; j < t.record.length; ++j){
						if(cond == Integer.parseInt(t.record[j].value[i])){
							found = true;
							System.out.println("Record " + j);
							displayRec(j, filename);
							System.out.println();
						}
					}
					if(found == false){
						System.out.println("No records match requested query");
					}
				}
				else if(t.attribute[i].type == 2){
					double cond = s.nextDouble();
					boolean found = false;
					
					for(int j = 0; j < t.record.length; ++j){
						if(cond == Double.parseDouble(t.record[j].value[i])){
							found = true;
							System.out.println("Record " + j);
							displayRec(j, filename);
							System.out.println();
						}
					}
					if(found == false){
						System.out.println("No records match requested query");
					}
				}
				else if(t.attribute[i].type == 3){
					String cond = s.next();
					boolean found = false;
					
					for(int j = 0; j < t.record.length; ++j){
						found = true;
						if(cond.compareTo((t.record[j].value[i])) == 0){
							System.out.println("Record " + j);
							displayRec(j, filename);
							System.out.println();
						}
					}
					if(found == false){
						System.out.println("No records match requested query");
					}
				}
				else if(t.attribute[i].type == 4){
					String cond = s.next();
					boolean found = false;
					
					for(int j = 0; j < t.record.length; ++j){
						found = true;
						if(cond.compareTo((t.record[j].value[i])) == 0){
							System.out.println("Record " + j);
							displayRec(j, filename);
							System.out.println();
						}
					}
					if(found == false){
						System.out.println("No records match requested query");
					}
				}

			}
		}
	}
}

class Table
{
       int 	numberOfAttributes;
       Attribute attribute[]; // attribute[i] records the information 
                              // of the ith attribute
       String header = "";
       Record record[];
       
       //Simple Constructor for table object
       public Table(ArrayList<Attribute> atts, Record[] recs){
    	   
    	   numberOfAttributes = atts.size();
    	   attribute = new Attribute[atts.size()];
    	   
    	   for(int i = 0; i < atts.size(); ++i){
    		   attribute[i] = new Attribute(atts.get(i).name, atts.get(i).type);
    	   }
    	   
    	   header += "[" + numberOfAttributes + "]";
    	   for(int i = 0; i < atts.size(); ++i){
    		   header += "[" + attribute[i].name + ":" + attribute[i].type + "]";
    	   }
    	   
    	   record = new Record[recs.length];
    	   for(int i = 0; i < recs.length; ++i){
    		   record[i] = new Record(recs[i].value.length);
    		   
    		   for(int j = 0; j < record[i].value.length; ++j){
    			   record[i].value[j] = recs[i].value[j];
    		   }
    	   }
    	   header += "[" + record.length + "]";
       }
       
	public void addNewRecord(Record r){
		
		Record[] copy = new Record[record.length + 1];
		
		for(int i = 0; i < record.length; ++i){
			copy[i] = record[i];
		}
		
		copy[record.length] = r;
		record = copy;
		
		header = "";
		header += "[" + numberOfAttributes + "]";
  	    for(int i = 0; i < attribute.length; ++i){
  		   
  		   header += "[" + attribute[i].name + ":" + attribute[i].type + "]";
  	   }
	   header += "[" + record.length + "]";
	}

	public void removeRecord(int index){
		
		Record[] copy = new Record[record.length - 1];
		int e = 0;
		
		for(int i = 0; i < record.length; ++i){
			if(i == index){
				++i;
			}
			
			if(i != record.length){
				copy[e] = record[i];
			}
			
			e++;
		}
		
		record = copy;
		
		header = "";
		header += "[" + numberOfAttributes + "]";
  	    for(int i = 0; i < attribute.length; ++i){
  		   
  		   header += "[" + attribute[i].name + ":" + attribute[i].type + "]";
  	   }
	   header += "[" + record.length + "]";

	}

}

class Attribute
{
       String 	name;
       int 		type;
       
       //Simple Constructor for Attribute object
       public Attribute(String n, int t){
    	   name = n;
    	   type = t;
       }
}

class Record
{
       String value[];   // value[i] stores the value of the ith          
                         // attribute, in text
                         // NOTE: you may need to convert the String
                         // into the type specified by attribute[i]
                         // in order to perform some operations. 
                         // For example, if value[0] = "1234" is 
                         // originally an integer, you need to convert 
                         // into a number before doing an "increment". 
                         // You can add some methods here to do such 
                         // conversions (e.g., toInt(), toDouble()) 
       
       public Record(int numAtts){
    	   
    	   value = new String[numAtts];
    	   
       }
       
}

