package cc.suitalk.arbitrarygen.statement;

import cc.suitalk.arbitrarygen.base.BaseStatement;
import cc.suitalk.arbitrarygen.base.Expression;
import cc.suitalk.arbitrarygen.base.PlainCodeBlock;
import cc.suitalk.arbitrarygen.core.Word;
import cc.suitalk.arbitrarygen.utils.Util;

/**
 * 
 * @author AlbieLiang
 *
 */
public class CaseStatement extends BaseStatement {

	private Expression mExpression;
	private Word mWordColon;

	public CaseStatement(Expression expression) {
		mExpression = expression;
		setCodeBlock(new PlainCodeBlock());
	}

	@Override
	public String genCode(String linefeed) {
		StringBuilder builder = new StringBuilder();
		String blank = getWordBlank(BLANK_1);

		builder.append(genCommendBlock(linefeed));
		builder.append(Util.getPrefix(this, "case"));
		builder.append(blank);
		builder.append(mExpression.genCode(linefeed));
		builder.append(blank);
		builder.append(mWordColon != null ? mWordColon : ":");
		builder.append(blank);
		PlainCodeBlock codeBlock = getCodeBlock();
		if (codeBlock != null) {
			for (int i = 0; i < codeBlock.countOfStatement(); i++) {
				BaseStatement statement  = codeBlock.getStatement(i);
				builder.append(getLinefeed(linefeed + TAB));
				builder.append(statement.genCode(linefeed + TAB));
			}
		}
		return builder.toString();
	}

	public Word getWordColon() {
		return mWordColon;
	}

	public void setWordColon(Word wordColon) {
		this.mWordColon = wordColon;
	}
}
