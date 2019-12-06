package API2.DynamicProxy;

public class TeacherLiu implements Teaching{

	@Override
	public void teach() {
		System.out.println("同学们你们好。我是刘老师，现在开始上课。");
	}
}
