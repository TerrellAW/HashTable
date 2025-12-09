JC = javac
JAR = jar
JVM = java
BUILD_DIR = build
BIN_DIR = bin

# Specifies that these are commands, not files
.PHONY: all clean run $(BUILD_DIR) $(BIN_DIR)

# Default make all
all: $(BIN_DIR)/Main.jar

# Make required directories
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)
$(BIN_DIR):
	@mkdir -p $(BIN_DIR)

# Make class file
$(BUILD_DIR)/%.class: ./%.java | $(BUILD_DIR)
	$(JC) -d $(BUILD_DIR) $<

# Make jar file
$(BIN_DIR)/Main.jar: $(BUILD_DIR)/Main.class | $(BIN_DIR)
	$(JAR) cvfe $@ Main -C $(BUILD_DIR) .

# Run the jar
run: $(BIN_DIR)/Main.jar
	$(JVM) -jar $(BIN_DIR)/Main.jar

# Remove bin and build directories
clean:
	rm -rf $(BUILD_DIR) $(BIN_DIR)
