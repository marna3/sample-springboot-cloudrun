# sample spring boot cloud run
サンプルのSpring BootアプリをCloud Runサービスでデプロイするためのリポジトリ

## デプロイメントパイプライン
![デプロイメントパイプライン](./images/deployment_pipline.svg)

## 前提条件
以下が実施済みであること
- GitHubとCircle CIの連携
- GitHubとSonar Cloudの連携
- Google Cloudのサービスアカウントの用意とキーの生成
  - 必要な権限
    - Artifact Registry 書き込み (roles/artifactregistry.writer)
    - Cloud Run デベロッパー (roles/run.developer)
- Circle CIに環境変数の設定を行っていること
  - コンテキスト: SonarCloud
    - SONAR_TOKEN (SonarCloudで発行するトークン)
    - SONAR_PROJECT_KEY (SonarCloudのプロジェクト作成時に作成するキー)
  - コンテキスト: GoogleCloud
    - GCP_PROJECT (Google CloudのProject ID)
    - GCP_REGION (Google Cloudで利用するリージョン)
    - GCP_SERVICE_ACCOUNT_KEY (用意したサービスアカウントのキーをbase64エンコードした値)
- Sonar Cloudの自動解析無効
