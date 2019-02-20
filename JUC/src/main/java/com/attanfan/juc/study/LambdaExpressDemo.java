package com.attanfan.juc.study;

@FunctionalInterface
interface Foo
{
    //public void sayHello();

    public int add(int x,int y);

    public default int div(int x,int y)
    {
        return x/y;
    }

    public static int mul(int x ,int y)
    {
        return x * y;
    }
}

/**
 * 使用lambda表达式的前提必须是函数式接口
 *
 * 函数式接口：这个类里面只有一个方法
 *
 * 1    lambda Express
 *
 *  拷贝小括号，写死右箭头，落地大括号
 *
 * 1.1 函数式接口才能用Lambda Express
 * 1.2 如何申明一个函数式接口?
 *  1.2.1:一个接口里有且只有只有一个方法，默认就是函数式接口（隐式声明）
 *         接口头加@FunctionInterface （显式声明）
 *
 * 1.3 default支持接口内有方法的实现
 *  1.3.1：接口里允许有默认方法的实现
 *      default开头的 可以有多个
 *
 *
 * 1.4 还可以有静态的方法实现
 *      使用 类名. 调用
 */
public class LambdaExpressDemo
{
    public static void main(String[] args)
    {
        /*Foo foo = new Foo()
        {
            @Override
            public void sayHello()
            {
                System.out.println("***********hello 0925");
            }

            @Override
            public int add(int x, int y)
            {
                return 11;
            }
        };
        foo.sayHello();*/


        Foo foo = (x,y) -> {
            System.out.println("*******come in");
            return x + y;
        };

        System.out.println(foo.add(3, 5));
        System.out.println(foo.div(10, 5));
        System.out.println(Foo.mul(1,5));
        System.out.println(foo.add(8, 9));
    }
}
