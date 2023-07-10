/* A car travels from a starting position to a destination which is target miles east of the starting position. There 
are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, 
fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of 
gas. The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one 
liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring 
all the gas from the station into the car.
Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach 
the destination, return -1. Note that if the car reaches a gas station with 0 fuel left, the car can still refuel 
there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
* Eg 1 :    target = 1        startFuel = 1    station = []                                 Output = 0  
* Eg 2 :    target = 100      starFuel = 10    station = [[10,60],[20,30],[30,30],[60,40]]  Output = 2  
* Eg 3 :    target = 50       startFuel = 1    station = [[1,18],[30,20]]                   Output = -1 
*/
import java.util.*;
public class Refuel
{
      public int MinimumRefuelingStations(int station[][], int target, int startFuel)
      {
            int res = 0, curDist = startFuel;       // Variable declaration...
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> station[b][1] - 
            station[a][1]);      //*  MaxHeap -> O(N)
            int i = 0; 
            while (curDist < target)      //! Comparison -> O(N)
            {
                  while (i < station.length && station[i][0] <= curDist)    //! Greedy Check -> O(k)
                        pq.add(i++);      // Adding the index of the station...
                  if (pq.isEmpty()) return -1;       // If Queue is Empty, then we cannot reach the target...
                  curDist+= station[pq.poll()][1];    // Adding the station fuel to the distance travelled...
                  ++res;
            }
            return res;
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x, y;
            System.out.print("Enter number of Stations : ");
            x = sc.nextInt();
            int array[][] = new int[x][2];
            for(int i = 0; i < array.length; i++)
            {
                  System.out.print("Enter position of the "+(i+1)+" Station : ");
                  array[i][0] = sc.nextInt();
                  System.out.print("Enter Fuel Tank of the "+(i+1)+" Station : ");
                  array[i][1] = sc.nextInt();
            }
            System.out.print("Enter destination position : ");
            x = sc.nextInt();
            System.out.print("Enter start fuel : ");
            y = sc.nextInt();
            Refuel refuel = new Refuel();      // Object creation...
            System.out.println("The Minimum Stations for Refilling : "+refuel.MinimumRefuelingStations(array, x, y));
            sc.close();
      }
}



//! Time Complexity -> O(N x k)
//* Space Complexity -> O(N)