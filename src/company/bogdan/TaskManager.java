package company.bogdan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TaskManager {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("company/bogdan/applicationContext.xml");
        Task task0 = context.getBean("myTaskPrototypeBean", Task.class);
        Task task1 = context.getBean("myTaskPrototypeBean", Task.class);
        Task task2 = context.getBean("myTaskPrototypeBean", Task.class);

        System.out.println(task0.getTaskName());
        System.out.println(task1.getTaskName());
        System.out.println(task2.getTaskName());
        System.out.println("Open tasks: " + Task.getNumberOfTasks());

        Task task3 = context.getBean("myTaskSingletonBean", Task.class);
        System.out.println(task3.getTaskName());
        System.out.println("Open tasks: " + Task.getNumberOfTasks());

        Task task4 = context.getBean("myTaskPrototypeBean", Task.class);
        System.out.println(task4.getTaskName());
        System.out.println("Open tasks: " + Task.getNumberOfTasks());

        Task task5 = context.getBean("myTaskSingletonBean", Task.class);
        System.out.println(task5.getTaskName());
        System.out.println("Open tasks: " + Task.getNumberOfTasks());

        context.close();
        System.out.println("Open tasks: " + Task.getNumberOfTasks());

    }
}
