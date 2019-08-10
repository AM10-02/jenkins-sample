#!/usr/bin/env groovy

import hudson.console.ConsoleNote

/**
 * この関数を実行した時点までのコンソールテキストを取得します
 */
def getConsoleText() {
	return ConsoleNote.removeNotes(currentBuild.rawBuild.log)
}

return this
