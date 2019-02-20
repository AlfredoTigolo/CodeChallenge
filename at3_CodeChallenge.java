

import java.io.FileNotFoundException;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.util.LinkedList;

/*
Creating a small reporting application that detect the following organization
Monthly cost depending on the number of managers, developers and qa in the department

Alfredo Tigolo 
alfredo.tigolo@yahoo.com
424-646-3493

  To run, type
  C:\>javac at3_CodeChallenge.java // to compile
  C:\>java at3_CodeChallenge test

*/

public class at3_CodeChallenge {
    
    /*
    class LinkedList {
        Node head; // head of list

        //Linked list 
        class Node {
            
            int data;
            Node next;

            // Constructor to create a new new
            //Next is by default initialized
            // as null
            Node ( int d ) { data = d; }

        }
    }
    */

    /* ===============
    This method takes in an array argument
    ================== */
    public static void readTextfromFile ( String[] myArgs)
    {

        java.io.DataOutputStream dos = null;
/*
     org.json.simple.JSON test = "{""
            'Deaprtments': ['Design', 'Development', 'Marketing'], 
            'Roles': [{
                    'roleName': 'QA Tester'
                    'Cost': 1000,
                    'Deaprtment': 'Development',
                    },
                    {
                    'roleName': 'Developer'
                    'Cost': 2000,
                    'Deaprtment': 'Development',
                    },
                    {
                    'roleName': 'Manager'
                    'Cost': 600,
                    'Deaprtment': 'Development',
                    }],
            'Employees': [{
                    'employeesName': 'James C',
                    'Role': 'Developer'
                    'ReportsTo': 'David F'
                        },
                        {
                    'employeesName': 'David F',
                    'Role': 'Manager'
                        },
                        {
                    'employeesName': 'Martin S',
                    'Role': 'QA Tester'
                    'ReportsTo': 'David F'
                        }],"};
*/
        try {

            if ( myArgs.length < 4) 
            {
                System.out.println(myArgs[0]);
                //System.exit(-1);
            }
            else 
            {
                // checks if file exsists then outputs a message
    			java.io.File outputfile = new java.io.File(myArgs[3]);
    			if (outputfile.exists()) {
                    System.out.println("File "+ outputfile + " already exists!");
                    System.out.print ("Delete it or use a different file name.  Rerun the program!");
                    System.exit(1);
                } 
            
                // reading or writing a file from local hard disk
                dos = new java.io.DataOutputStream ( new java.io.FileOutputStream(outputfile));
            }
        }//end try
        catch ( FileNotFoundException nofile ) { nofile.printStackTrace(); }
    }

    public static void main (String args[]) throws
        FileNotFoundException
    {
        //variables defined
        double temp = 0;
        java.util.LinkedList dept = new LinkedList();
        java.util.LinkedList exampleDept = new LinkedList();

        //these are the top level management
        java.util.LinkedList managerA = new LinkedList();
        java.util.LinkedList managerB = new LinkedList();
        java.util.LinkedList managerC = new LinkedList();
        java.util.LinkedList managerD = new LinkedList();
        java.util.LinkedList managerE = new LinkedList();

        // keep looping active while reading data
        readTextfromFile( args );


        // need key value to keep track of employee
        // every manager you find, you must indicate who is reporting to them

        //System.out.println("Hello World");        
       
            System.out.println( "unit testing getAllocation");
            temp = getAllocation(1);
            System.out.println( temp );
            temp = getAllocation(2);
            System.out.println ( temp );
            temp = getAllocation(3);
            System.out.println( temp );
            temp = 0;
            System.out.println( temp );

            System.out.println( "unit testing for linkedlist of dept");
            dept.add(1);
            dept.add(2);
            dept.add(3);

            for ( int j = 0; j < dept.size(); j++ )
            {
                temp = getAllocation ( (int) dept.get(j) );
                System.out.println( temp + "\n");
            }

            System.out.println( "unit testing for returnDept totals");
            temp = returnDept( dept );
            System.out.println ( temp + "\n" );

            System.out.println("until testing example scenario");
            exampleDept.add(3);
            exampleDept.add(3);
            exampleDept.add(1);
            exampleDept.add(2);
            exampleDept.add(3);
            exampleDept.add(3);
            exampleDept.add(3);
            exampleDept.add(1);
            temp = returnDept ( exampleDept );
            System.out.println( temp + "\n");

            System.out.println( "Manager A");
            managerA.add(3);
            managerA.add(3);
            managerA.add(2);
            managerA.add(1);
            System.out.println( "Manager A Total");
            temp = returnDept ( managerA );
            System.out.println( temp + "\n");

            System.out.println( "Manager B");
            managerB.add(3);
            managerB.add(2);
            managerB.add(1);
            System.out.println( "Manager B Total");
            temp = returnDept ( managerB );
            System.out.println( temp + "\n");

            System.out.println( "Manager C");
            managerC.add(3);
            managerC.add(3);        
            System.out.println( "Manager C Total");
            temp = returnDept ( managerC );
            System.out.println( temp + "\n");

            System.out.println( "Manager D");
            managerD.add(3);
            System.out.println( "Manager D Total");
            temp = returnDept ( managerD );
            System.out.println( temp + "\n");

            System.out.println( "Manager E");
            managerE.add(3);
            managerE.add(1);
            System.out.println( "Manager E Total");
            temp = returnDept ( managerE );
            System.out.println( temp + "\n");
        

    }

    // return allocation number depending on 1,2,3 values
    public static double getAllocation ( int i)
    {
        double devs = 2000;
        double qas = 1000;
        double mgrs = 600;

        switch ( i )
            {
                case 1:
                    return devs;
                    
                case 2:
                    return qas;
                    
                case 3:
                    return mgrs;
                    
            }
        return 0;
    }

    // returns dept totals of the entire linked list
    public static double returnDept ( java.util.LinkedList deptList ) {

        double tmp = 0;
        for ( int j = 0; j < deptList.size(); j++ )
        {
            tmp += getAllocation ( (int) deptList.get(j) );
            if ( deptList.size() == 1)
               System.out.println( "Manager with no one reporting to them" );
        }
        return tmp;
    }


}