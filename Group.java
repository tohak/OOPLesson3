package com.konovalov;

import java.util.Arrays;

public class Group {
	private Student[] array = new Student[10];

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student[] getArray() {
		return array;
	}

	public void add(Student student) throws MyException{
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				array[i] = student;
				return;
			}
		}
		throw new MyException();
	}

	public void delete(Student student) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == student) {
				array[i] = null;
			}
		}
	}

	public Student search(String surname) {
		Student result = null;
		for (int i = 0; i < 10; i++) {
			if (array[i] != null && array[i].getSurname().equals(surname)) {
				result = array[i];

			}
			result = array[i];

		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Student[] sorted = sortArray(array);
		for (int i = 0; i < sorted.length; i++) {
			if (sorted[i] != null) {
				sb.append(sorted[i]);
				sb.append(System.lineSeparator());
			}
		}

		return sb.toString();
	}

	private Student[] sortArray(Student[] array) {
		Student[] tmpArr = Arrays.copyOf(array, array.length);
		Student[] result = new Student[10];
		int cnt = 0;
		boolean flag = true;
		while (flag) {
			Student st = findFirst(tmpArr);
			if (st != null) {
				result[cnt++] = st;
			} else {
				flag = false;
			}
		}

		return result;

	}

	private Student findFirst(Student[] array) {
		Student result = array[0];
		int index = 0;
		for (int i = 1; i < array.length; i++) {
			if ((array[i]) != null) {
				if ((result == null) || (array[i].getSurname().compareTo(result.getSurname()) <= 0)) {
					result = array[i];
					index = i;
				}
			}
		}

		array[index] = null;
		return result;
	}
}
