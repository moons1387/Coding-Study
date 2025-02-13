package kr.or.ddit.basic;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) {

		System.out.println("static 변수값 : " + PrintAnnotation.id);

		// reflection API 이용한 메서드 정보 접근하기
		// 선언된 메서드 목록 가져오기

		Method[] methodArr = Service.class.getDeclaredMethods();

		for (Method m : methodArr) {
			System.out.println(m.getName()); // 메서드명 출력...
			Annotation[] annos = m.getAnnotations();
			for (Annotation anno : annos) {
				if (anno.annotationType().getSimpleName().equals("PrintAnnotation")) {

					PrintAnnotation printAnno = (PrintAnnotation) anno;

					for (int i = 0; i < printAnno.count(); i++) {
						System.out.print(printAnno.value()); // count 수만큼 value값 출력...
					}
				}
			}
			System.out.println();
		}
	}
}
