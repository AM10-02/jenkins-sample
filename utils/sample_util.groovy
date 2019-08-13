#!/usr/bin/env groovy

import hudson.console.ConsoleNote

/**
 * この関数を実行した時点までのコンソールテキストを取得します
 */
def getConsoleText() {
	return ConsoleNote.removeNotes(currentBuild.rawBuild.log)
}

/**
 * この関数を実行した時点までのコンソールテキストを成果物として保存します
 */
def archiveConsoleText() {
	dir('archiveConsoleText') {
		writeFile encoding: 'utf-8', file: 'consoleText.txt', text: consoleText
		archiveArtifacts 'consoleText.txt'
		deleteDir()
	}
}

return this
