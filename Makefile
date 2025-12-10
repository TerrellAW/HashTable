JC = javac
JAR = jar
JVM = java
ENTRY = app.AppDriver
SRC_DIR = src/app
BUILD_DIR = build
BIN_DIR = bin
EXEC = HashTable.jar
SRC_FILES = $(wildcard $(SRC_DIR)/*.java)

# Specifies that these are commands, not files
.PHONY: all clean run $(BUILD_DIR) $(BIN_DIR) compile_all

# Default make all
all: compile_all $(BIN_DIR)/$(EXEC)

compile_all: $(BUILD_DIR)
	@echo "Compiling source files to $(BUILD_DIR)/"
	$(JC) -d $(BUILD_DIR) $(SRC_FILES)

# Make required directories
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

$(BIN_DIR):
	@mkdir -p $(BIN_DIR)

# The JAR depends on the explicit list of all class files
$(BIN_DIR)/$(EXEC): $(BUILD_DIR) $(BIN_DIR)
	@echo "Creating JAR: $@"
	# cvfe: Create, Verbose, File name, Entry point, Change Dir to build
	$(JAR) cvfe $@ $(ENTRY) -C $(BUILD_DIR) .

# Run the jar
run: $(BIN_DIR)/$(EXEC)
	@echo "Running $(EXEC)"
	$(JVM) -jar $<

# Remove build artifacts
clean:
	@echo "Cleaning directories: $(BUILD_DIR) and $(BIN_DIR)"
	rm -rf $(BUILD_DIR) $(BIN_DIR)
