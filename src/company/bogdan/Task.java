package company.bogdan;

import java.util.Random;

public class Task {

    private String taskName;
    private Integer taskId; // directly corelated to numberOfTasks
    private Integer executionTime;
    private static Integer numberOfTasks;

    public void run(){
        try{
            Thread.sleep(executionTime);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    Integer generateId(){
        Integer result = numberOfTasks - 1;
        return result;
    }

    private void performInitialization(){
        if(numberOfTasks == null){
            numberOfTasks = 1;
            this.taskId = generateId();
        }else{
            numberOfTasks++;
            this.taskId = generateId();
        }

        this.taskName = "Task" + this.taskId;

        Random random = new Random();
        this.executionTime = random.nextInt(1, 20);
    }

    private void performDestruction(){
        System.out.println(this.taskName + " is killed");
        numberOfTasks--;
    }

    public String getTaskName() {
        return taskName;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public static Integer getNumberOfTasks() {
        return numberOfTasks;
    }

}
