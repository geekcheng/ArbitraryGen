package cc.suitalk.arbitrarygen.core;

import cc.suitalk.arbitrarygen.base.JavaFileObject;
import cc.suitalk.arbitrarygen.extension.ICustomizeGenerator;

/**
 * 
 * @author AlbieLiang
 * 
 */
public class CodeGenerator implements ICustomizeGenerator {

	public static final String LINEFEED_UNIT = "\r\n";
	private JavaFileObject mJavaFileObject;
	private String mLinefeed = LINEFEED_UNIT;

	public CodeGenerator(JavaFileObject javaFileObject) {
		if (javaFileObject == null) {
			throw new RuntimeException("JavaFileObject can not be null.");
		}
		mJavaFileObject = javaFileObject;
		mLinefeed = LINEFEED_UNIT;
	}

	@Override
	public String genCode() {
		return mJavaFileObject.genCode(mLinefeed);
	}
}
