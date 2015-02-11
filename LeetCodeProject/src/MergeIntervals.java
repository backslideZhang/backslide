import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class MergeIntervals {
	public void solution(){
		List<Interval> intervals = new LinkedList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		for (Interval interval : merge(intervals)){
			System.out.println(interval.start+"");
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new LinkedList<Interval>();
		
		Collections.sort(intervals,new Comparator<Interval>() {
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
		});
		
		for (Interval interval : intervals){
			if (result.size() <= 0){
				result.add(interval);
			}else{
				Interval lastInterval = result.get(result.size()-1);
				if (lastInterval.end < interval.start){
					result.add(interval);
				}else{
					lastInterval.end = Math.max(lastInterval.end, interval.end);
				}
			}
		}
		
		return result;
    }
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
