# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Clojure `deps-new` template for generating web service projects. The template creates full-stack Clojure services with:

- **Web framework**: Ring + Reitit for HTTP routing
- **Database**: PostgreSQL with next.jdbc, HikariCP connection pooling, and Ragtime migrations
- **System management**: Integrant for dependency injection and system lifecycle
- **Configuration**: Aero for environment-based config
- **Logging**: Telemere with tools.logging
- **Data validation**: Malli schemas
- **Content negotiation**: Muuntaja for JSON/EDN handling
- **OAuth2**: Ring-oauth2 integration

## Development Commands

### Template Development
- **Run tests**: `clojure -T:build test` or `./scripts/test.sh`
- **Generate example project**: `./scripts/generate.sh` (creates `../generated-service`)
- **Clean up**: `./scripts/cleanup.sh`

### Generated Project Commands
Generated projects include these standard commands:
- **Run tests**: `clojure -T:build test`
- **Build CI pipeline**: `clojure -T:build ci` 
- **Install locally**: `clojure -T:build install`
- **Deploy to Clojars**: `clojure -T:build deploy`
- **Start dev REPL**: `clojure -M:dev`
- **Run application**: `clojure -M:run`

## Architecture

### Template Structure
- `resources/dfornika/clj_service/` - Template files that get transformed
- `src/dfornika/clj_service.clj` - Template transformation functions (`data-fn`, `template-fn`, `post-process-fn`)
- `template.edn` - Defines file transformations and mappings

### Generated Project Architecture
The template generates projects with this structure:
- **System lifecycle**: Integrant manages component dependencies (database, web server, config)
- **Configuration**: Environment-specific EDN files loaded via Aero
- **Database layer**: Repository pattern with next.jdbc and HoneySQL
- **Web layer**: Ring handlers with Reitit routing and Muuntaja content negotiation
- **CLI interface**: tools.cli for command-line argument parsing

### Key Template Files
- `main.tmpl` - Application entry point with CLI parsing
- `system.tmpl` - Integrant system configuration
- `config.tmpl` - Aero configuration loading
- `database.tmpl` - Database connection and utilities
- `handlers.tmpl` - HTTP request handlers
- `repositories/users.tmpl` - Example repository implementation

## Template Variable System
Templates use `{{variable}}` syntax with these common variables:
- `{{top/ns}}` - Top-level namespace (e.g., "mycompany")
- `{{main/ns}}` - Main namespace (e.g., "myservice") 
- `{{top/file}}` - File path version of top namespace
- `{{raw-name}}` - Full project name
- `{{developer}}` - Developer name
- `{{now/year}}` - Current year