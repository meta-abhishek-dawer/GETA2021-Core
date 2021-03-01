package SCCR;

import java.util.Arrays;
import java.util.Scanner;

public class JobSchedular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfProcesses = sc.nextInt(); // number of processes
		int[][] processes = new int[numberOfProcesses][2]; 
		
		// input for arrival and burst time
		for(int i=0;i<numberOfProcesses;i++){
			for(int j=0;j<2;j++){
				processes[i][j] = sc.nextInt();
			}
		}
		// object for calling different methods
		JobSchedular obj1 = new JobSchedular();
		
		//processes completion time
		int[] waitingTime = obj1.waitingProcess(processes,numberOfProcesses);
		
		//processes turnaround time
		int[] turnaroundTime = obj1.turnaroundProcess(processes, numberOfProcesses,waitingTime);
			
		// average waiting time of processes
		float avgWaitingTime = obj1.averageWaitingTime(waitingTime,numberOfProcesses);
			
		// maximum waiting time in queue
		int maxWaitingTime = obj1.calculateMaxWaitingTime(waitingTime,numberOfProcesses);
			
		//completion time for each process
		int[] completionTime = obj1.calculateCompletionTime(waitingTime,turnaroundTime,numberOfProcesses);
			
		// prints all the results of different function
		System.out.print("S No. "+ "Arrival Time  "+ "Burst Time  "+ "Waiting Time  "+ "TurnAround Time "+ "Completion Time  ");
		System.out.println();	
		for(int i=0;i<numberOfProcesses;i++){
			System.out.println(i+ " "+ processes[i][0]+" "+ processes[i][1]+ " "+waitingTime[i]+ " "+ turnaroundTime[i]+ " "+completionTime[i]);
			System.out.println();
		}
			
		System.out.println("Average waiting Time:- "+avgWaitingTime);
		System.out.println("Maximum WaitingTime:- "+maxWaitingTime);
	}
	
	// function to calculate waiting time for each process
	public int[] waitingProcess(int[][] processes, int numberOfProcesses){
		int[] result= new int[numberOfProcesses];
		int[] workTime = new int[numberOfProcesses];
		workTime[0]=0;
		result[0]=0;
		for(int i=1;i<numberOfProcesses;i++){
			int timeWastedInQueue =0;
			workTime[i] = workTime[i-1]+ processes[i-1][1];
			result[i] = workTime[i]- processes[i][0];
			if(result[i]<0){
				timeWastedInQueue = Math.abs(result[i]);
				result[i]=0;
			}
			workTime[i]= workTime[i]+ timeWastedInQueue;
		}	
		return result;
	}
		
	// function to calculate turnaround time for each process
	public int[] turnaroundProcess(int[][] processes, int numberOfProcesses,int[] waitingTime){
		int[] result= new int[numberOfProcesses];
		for(int i=0;i<numberOfProcesses;i++){
			result[i] = processes[i][1]+ waitingTime[i];
		}	
		return result;
	}
		
	// function to calculate average waiting time for each process
	public float averageWaitingTime(int[] waitingTime,int numberOfProcesses){
		float sumOfWaitingTime =0;
		for(int i=0;i<numberOfProcesses;i++){
			sumOfWaitingTime= waitingTime[i];
		}	
		return sumOfWaitingTime/(float)numberOfProcesses;
	}
		
	// function to calculate maximum waiting time for each process
	public int calculateMaxWaitingTime(int[] waitingTime,int numberOfProcesses){
		Arrays.sort(waitingTime);
		return waitingTime[numberOfProcesses-1];
	}

	// function to calculate completion time for each process
	public int[] calculateCompletionTime(int[] waitingTime,int[] turnaroundTime,int n){
		int[] completionTime = new int[n];
		for(int i=0;i<n;i++){
			completionTime[i]= waitingTime[i]+ turnaroundTime[i];
		}	
		return completionTime;
	}
		
}