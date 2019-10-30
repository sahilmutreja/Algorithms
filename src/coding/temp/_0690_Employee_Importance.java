/**
 *  @author Yunxiang He
 *  @date 01/29/2018
 */

package coding.temp;

import common.Employee;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*

You are given a data structure of employee information, which includes the employee's unique id, his importance value and his direct subordinates' id.

For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
They have importance value 15, 10 and 5, respectively. 
Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. 
Note that although employee 3 is also a subordinate of employee 1, the relationship is not direct.

Now given the employee information of a company, and an employee id, you need to return the total importance value of this employee and all his subordinates.


Example 1:
    Input: 
        [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
    Output: 
        11
    Explanation:
        Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
        They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.


Note:
    One employee has at most one direct leader and may have several subordinates.
    The maximum number of employees won't exceed 2000.

*/

public class _0690_Employee_Importance {

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getImportance_BFS(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        Queue<Integer> que = new ArrayDeque<>();
        int importance = 0;
        que.offer(id);
        int next;
        while (!que.isEmpty()) {
            next = que.poll();
            importance += map.get(next).importance;
            que.addAll(map.get(next).subordinates);
        }
        return importance;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getImportance_DFS(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return DFS(map, id);
    }

    private int DFS(Map<Integer, Employee> map, int id) {
        int importance = map.get(id).importance;
        for (int sub : map.get(id).subordinates) {
            importance += DFS(map, sub);
        }
        return importance;
    }

}
