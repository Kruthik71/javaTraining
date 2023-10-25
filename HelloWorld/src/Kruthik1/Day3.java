package Kruthik1;

interface test
{
    public void main(String args[]);
    public void display();
}


class Testclass implements test
{
   public void display()
   {
       System.out.println("Hello");
    }
   public void main(String[] args)
   {
       Testclass t=new Testclass();
       t.display();
    }
}
