import java.io.BufferedWriter;
 import java.io.IOException;
 import java.util.Scanner;

public class Main {
	
  static java.util.Random random = new java.util.Random();
   static boolean mode1;
   static boolean mode2;
  static boolean mode3;
   static boolean mode4;
  static int PasswordsInt = 16000;
 static int sizePassword;
 static String[] passwordForWritering = new String[16000];
  
 static String Space;
   String password;
  static String Symbols = "%*)?@#$~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  
  int i;
  int randomnum;
private static Scanner scanner;
  public String GetPassword(int sizePassword, boolean useSings, boolean useBigLetters, boolean useSmallLetters, boolean useNumbers)  {
   this.password = "";
   this.i = 0;
   this.randomnum = 0;
  
   while (this.i != sizePassword) {
    this.i += 1;
    this.randomnum = random.nextInt(Symbols.length());
   
   if ((!useSings) && (this.randomnum < 8)) {
     this.i -= 1;

   }
   else if ((!useBigLetters) && (this.randomnum > 7) && (this.randomnum < 34)) {
     this.i -= 1;

    }
     else if ((!useSmallLetters) && (this.randomnum > 33) && (this.randomnum < 60)) {
      this.i -= 1;

   }
   else if ((!useNumbers) && (this.randomnum > 59)) {
     this.i -= 1;
  }
   else
   {
      this.password += Symbols.charAt(this.randomnum); }
  }
  return this.password;
   }
  
 public static void main(String[] args) {
			  new AddGUI();
   System.out.println();
   System.out.println("PasswordGP на Java | Version 1.53 | Готовая версия");
   System.out.println("Сделано программистом Aleser | Канал на YouTube: 'AleserGaming'");
   System.out.println("В связи с проблемами сравнения русских букв в CMD, нужно задавать параметры ядру ГП на английских буквах");
   System.out.println();
   Main main = new Main();
  scanner = new Scanner(System.in);
  while (true) {
   try {
     System.out.print("Количество символов в твоём пароле: ");
   sizePassword = Integer.parseInt(scanner.nextLine());
	  break;
    }
   catch (Exception ex)
   {
     System.out.println("Произошла ошибка! Код ошибки - 1");
     System.out.println(ex.getLocalizedMessage());
    System.out.println(ex.hashCode());
     System.out.println(ex.getStackTrace());
     System.out.println(ex.getCause());
      System.out.println(ex.getClass());
     System.out.println(ex.getSuppressed());
     System.out.println();
      }
    }
     
 
   System.out.print("Нужны ли в твоём пароле знаки? Yes/No: ");
    if (scanner.next().toLowerCase().equals("yes")) {
      mode1 = true;
    }
    System.out.print("Нужны ли в твоём пароле большие латинские буквы? Yes/No: ");
    if (scanner.next().toLowerCase().equals("yes")) {
      mode2 = true;
    }
     System.out.print("Нужны ли в твоём пароле маленькие латинские буквы? Yes/No: ");
   if (scanner.next().toLowerCase().equals("yes")) {
      mode3 = true;
   }
    System.out.print("Нужны ли в твоём пароле числа? Yes/No: ");
   if (scanner.next().toLowerCase().equals("yes")) {
      mode4 = true;
    }
    
    System.out.println("Кол-во символов           [" + sizePassword + "]");
    System.out.println("Знаки                     [" + mode1 + "]");
    System.out.println("Большие латинские буквы   [" + mode2 + "]");
    System.out.println("Маленькие латниские буквы [" + mode3 + "]");
   System.out.println("Числа                     [" + mode4 + "]");
  
    System.out.println("Подожди немного, я создаю пароли... ");
     try {
       BufferedWriter bwPGP = new BufferedWriter(new java.io.FileWriter("PasswordsGP.txt"));
     BufferedWriter bwCopiesPGP = new BufferedWriter(new java.io.FileWriter("ID" + random.nextInt(1000000) + " PGP" + ".alesergaming"));
      String lineSeparator = System.getProperty("line.separator");
     for (int ii = 0; ii < PasswordsInt; ii++) {
       passwordForWritering[ii] = main.GetPassword(sizePassword, mode1, mode2, mode3, mode4);
      }
    System.out.println("Пароли готовы! Осталось их записать в файлы, подожди ещё чуток...");
      for (int ii = 1; ii < PasswordsInt + 1; ii++) {
        if (ii < 10) {
          Space = "      ";
        }
        else if ((ii > 9) && (ii < 100)) {
          Space = "     ";
       }
       else if ((ii > 99) && (ii < 1000)) {
          Space = "    ";
        }
      else if ((ii > 999) && (ii < 10000)) {
         Space = "   ";
         } else {
           Space = "  ";
         }
         bwPGP.write("[" + ii + "]" + Space + passwordForWritering[(ii - 1)] + lineSeparator);
       bwCopiesPGP.write("[" + ii + "]" + Space + passwordForWritering[(ii - 1)] + lineSeparator);
       }
     bwPGP.flush();
      bwPGP.close();
     bwCopiesPGP.flush();
      bwCopiesPGP.close();
    }
    catch (IOException ex)
    {
       System.out.println("Произошла ошибка! Код ошибки - 2");
       System.out.println(ex.getLocalizedMessage());
       System.out.println(ex.hashCode());
       System.out.println(ex.getStackTrace());
       System.out.println(ex.getCause());
       System.out.println(ex.getClass());
      System.out.println(ex.getSuppressed());
       System.out.println();
     }
    System.out.println("Готово! Можешь закрыть окно.");
     while (true) {
    	 
     }
   }
 }
