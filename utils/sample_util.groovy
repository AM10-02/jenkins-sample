#!/usr/bin/env groovy

import hudson.console.ConsoleNote
import com.cloudbees.workflow.rest.external.RunExt
import com.cloudbees.workflow.util.JSONReadWrite
import groovy.json.JsonSlurperClassic

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

/**
 * /job/:job-name/:run-id/wfapi/describe で取得できるJSONを取得します
 */
def getRunExt(build) {
	return RunExt.create(build)
}

/**
 * インスタンスからJSON文字列を生成します
 */
def toJsonString(object) {
	def rw = new JSONReadWrite()
	return rw.toString(object)
}

/**
 * JSONの文字列を、Mapに変換します
 */
@NonCPS
def toJsonData(jsonString) {
	return new JsonSlurperClassic().parseText(jsonString)
}

return this
