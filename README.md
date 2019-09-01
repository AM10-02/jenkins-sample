# Jenkins Sample

## 概要
本リポジトリは、Jenkinsfileのサンプルを記載します。  
ここでのサンプルは、[AM10-02/docker-jenkins](https://github.com/AM10-02/docker-jenkins)で動作確認を行っています。  
`Declarative Pipeline`と`Scripted Pipeline`の2種類作成しており、どちらも同じ内容となっています。

## sample_util.groovy
サンプルで使用する処理のユーティリティです。  
Pipelineの種類に問わず使用できるスクリプトを記載しています。

## basic_sample
基本的な処理を行うサンプルジョブです。  
サンプル用の処理はこちらで確認できます。  
下流ビルドの結果に合わせて、ビルド結果を変えています。  
`ERROR > UNSTABLE > SUCCESS`の優先度で、最終的なビルド結果としています。

## parallel_build
並列ビルドの下流ジョブとして実行するジョブです。  
`basic_sample`のresult変更サンプル用に、ビルド番号によって結果が変わるようになっています。

## build_plugin
プラグインをビルドするジョブです。  
成果物として保存する`hpi`ファイルをインストールすると、動作確認を行うことができます。
