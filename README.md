# springboot
### 명령어 저장
```
export LOG_LEVEL="INFO"
export MONGODB_URL="mongodb://database:database@localhost:27017/company?authSource=admin&readPreference=secondaryPreferred"
```

### Open Telemetry 환경변수 설정
```
export OTEL_EXPORTER_OTLP_TRACES_PROTOCOL=grpc
export OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://localhost:4317

export OTEL_EXPORTER_OTLP_TRACES_PROTOCOL=http/protobuf
export OTEL_EXPORTER_OTLP_TRACES_ENDPOINT=http://localhost:4318/v1/traces
```