package com.example.material3demo

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId

@Composable
fun ComponentsScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = stringResource(R.string.components_title),
            style = MaterialTheme.typography.headlineLarge
        )

        // Badge & BadgedBox
        BadgeSection()

        // Buttons
        ButtonsSection()

        // Card
        CardSection()

        // Checkboxes
        CheckboxesSection()

        // Chips
        ChipsSection()

        // DatePicker
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DatePickerSection()
        }

        // Dividers
        DividersSection()

        // FloatingActionButton
        FloatingActionButtonSection()

        // DropdownMenu
        DropdownMenuSection()

        // Lazy Lists
        LazyListsSection()

        // Progress Indicators
        ProgressIndicatorsSection()

        // RadioButton
        RadioButtonSection()

        // SearchBar
        SearchBarSection()

        // ModalBottomSheet
        ModalBottomSheetSection()

        // Navigation Bar
        NavigationBarSection()

        // Slider
        SliderSection()

        // Snackbar
        SnackbarSection()

        // Switch
        SwitchSection()

        // Tabs
        TabsSection()

        // TextFields
        TextFieldsSection()

        // TimeInput
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            TimeInputSection()
        }

        // Tooltip
        TooltipSection()

        // TopAppBar
        TopAppBarSection()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.badge_title),
                style = MaterialTheme.typography.titleLarge
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Badge(
                    containerColor = BadgeDefaults.containerColor
                ) {
                    Text("5")
                }

                BadgedBox(
                    badge = {
                        Badge(
                            containerColor = BadgeDefaults.containerColor
                        ) {
                            Text("99+")
                        }
                    }
                ) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Notifications, contentDescription = stringResource(R.string.cd_notifications))
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonsSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.buttons_title),
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(),
                elevation = ButtonDefaults.buttonElevation()
            ) {
                Text(stringResource(R.string.button_filled))
            }

            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(),
                elevation = ButtonDefaults.buttonElevation()
            ) {
                Text(stringResource(R.string.button_outlined))
            }

            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(),
                elevation = ButtonDefaults.buttonElevation()
            ) {
                Text(stringResource(R.string.button_text))
            }
        }
    }
}

@Composable
fun CardSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.card_title),
                style = MaterialTheme.typography.titleLarge
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(R.string.card_filled_title),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(R.string.card_filled_content),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
fun CheckboxesSection() {
    var checked by remember { mutableStateOf(false) }
    var triState by remember { mutableStateOf(ToggleableState.Indeterminate) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.checkbox_title),
                style = MaterialTheme.typography.titleLarge
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = CheckboxDefaults.colors()
                )
                Text(stringResource(if (checked) R.string.checkbox_checked else R.string.checkbox_unchecked))
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TriStateCheckbox(
                    state = triState,
                    onClick = {
                        triState = when (triState) {
                            ToggleableState.Indeterminate -> ToggleableState.On
                            ToggleableState.On -> ToggleableState.Off
                            ToggleableState.Off -> ToggleableState.Indeterminate
                        }
                    }
                )
                Text(stringResource(R.string.checkbox_indeterminate))
            }
        }
    }
}

@Composable
fun ChipsSection() {
    var assistSelected by remember { mutableStateOf(false) }
    var filterSelected by remember { mutableStateOf(false) }
    var inputSelected by remember { mutableStateOf(false) }
    var suggestionSelected by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.chips_title),
                style = MaterialTheme.typography.titleLarge
            )

            AssistChip(
                onClick = { assistSelected = !assistSelected },
                label = { Text(stringResource(R.string.chip_assist)) },
                leadingIcon = {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = stringResource(R.string.cd_info),
                        modifier = Modifier.size(18.dp)
                    )
                },
                colors = AssistChipDefaults.assistChipColors(),
                elevation = AssistChipDefaults.assistChipElevation()
            )

            FilterChip(
                selected = filterSelected,
                onClick = { filterSelected = !filterSelected },
                label = { Text(stringResource(R.string.chip_filter)) },
                leadingIcon = if (filterSelected) {
                    {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = stringResource(R.string.cd_check),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                } else null,
                colors = FilterChipDefaults.filterChipColors(),
                elevation = FilterChipDefaults.filterChipElevation()
            )

            InputChip(
                selected = inputSelected,
                onClick = { inputSelected = !inputSelected },
                label = { Text(stringResource(R.string.chip_input)) },
                trailingIcon = {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = stringResource(R.string.cd_close),
                        modifier = Modifier.size(18.dp)
                    )
                },
                colors = InputChipDefaults.inputChipColors(),
                elevation = InputChipDefaults.inputChipElevation()
            )

            SuggestionChip(
                onClick = { suggestionSelected = !suggestionSelected },
                label = { Text(stringResource(R.string.chip_suggestion)) },
                colors = SuggestionChipDefaults.suggestionChipColors(),
                elevation = SuggestionChipDefaults.suggestionChipElevation()
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSection() {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var selectedDate by remember { mutableStateOf<Long?>(null) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.datepicker_title),
                style = MaterialTheme.typography.titleLarge
            )

            Button(onClick = { showDatePicker = true }) {
                Text(stringResource(R.string.datepicker_show_button))
            }

            selectedDate?.let {
                Text(
                    stringResource(
                        R.string.datepicker_selected_date,
                        Instant.ofEpochMilli(it).atZone(ZoneId.systemDefault())
                            .toLocalDate().toString()
                    )
                )
            }

            if (showDatePicker) {
                ModalBottomSheet(
                    onDismissRequest = { showDatePicker = false }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        DatePicker(
                            state = datePickerState,
                            colors = DatePickerDefaults.colors()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = { showDatePicker = false }) {
                                Text(stringResource(R.string.button_cancel))
                            }
                            TextButton(
                                onClick = {
                                    selectedDate = datePickerState.selectedDateMillis
                                    showDatePicker = false
                                }
                            ) {
                                Text(stringResource(R.string.button_ok))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DividersSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.divider_title),
                style = MaterialTheme.typography.titleLarge
            )

            Text("Tekst przed poziomym")
            HorizontalDivider(color = DividerDefaults.color)
            Text("Tekst po poziomym")

            Row(
                modifier = Modifier.height(100.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("Tekst")
                VerticalDivider(color = DividerDefaults.color)
                Text("Po prawej")
            }
        }
    }
}

@Composable
fun DropdownMenuSection() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Opcja 1") }
    val options = listOf("Opcja 1", "Opcja 2", "Opcja 3", "Opcja 4")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.menu_title),
                style = MaterialTheme.typography.titleLarge
            )

            Box {
                Button(onClick = { expanded = true }) {
                    Text(selectedOption)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedOption = option
                                expanded = false
                            },
                            colors = MenuDefaults.itemColors()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProgressIndicatorsSection() {
    var progress by remember { mutableStateOf(0.3f) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.circular_progress_title),
                style = MaterialTheme.typography.titleLarge
            )

            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.size(48.dp),
                color = ProgressIndicatorDefaults.circularColor
            )

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxWidth(),
                color = ProgressIndicatorDefaults.linearColor
            )

            Slider(
                value = progress,
                onValueChange = { progress = it },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun RadioButtonSection() {
    var selectedOption by remember { mutableStateOf("Opcja 1") }
    val options = listOf("Opcja 1", "Opcja 2", "Opcja 3")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.radio_button_title),
                style = MaterialTheme.typography.titleLarge
            )

            options.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option },
                        colors = RadioButtonDefaults.colors()
                    )
                    Text(option)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSection() {
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.search_bar_title),
                style = MaterialTheme.typography.titleLarge
            )

            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = {
                            active = false
                        },
                        expanded = active,
                        onExpandedChange = { active = it }
                    )
                },
                expanded = active,
                onExpandedChange = { active = it },
                colors = SearchBarDefaults.colors()
            ) {
                Text("Wyniki dla: $query")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetSection() {
    var showBottomSheet by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.modal_bottom_sheet_title),
                style = MaterialTheme.typography.titleLarge
            )

            Button(onClick = { showBottomSheet = true }) {
                Text("Pokaż ModalBottomSheet")
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = rememberModalBottomSheetState(),
            dragHandle = { BottomSheetDefaults.DragHandle() },
            containerColor = BottomSheetDefaults.ContainerColor
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "ModalBottomSheet",
                    style = MaterialTheme.typography.titleLarge
                )
                Text("To jest przykład ModalBottomSheet")
                Button(
                    onClick = { showBottomSheet = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Zamknij")
                }
            }
        }
    }
}

@Composable
fun SliderSection() {
    var sliderValue by remember { mutableStateOf(50f) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.slider_title),
                style = MaterialTheme.typography.titleLarge
            )

            Text("Wartość: ${sliderValue.toInt()}")
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..100f,
                steps = 9,
                colors = SliderDefaults.colors()
            )
        }
    }
}

@Composable
fun SnackbarSection() {
    val snackbarHostState = remember { SnackbarHostState() }
    var showSnackbar by remember { mutableStateOf(false) }
    val snackbarMessage = stringResource(R.string.snackbar_message)
    val snackbarAction = stringResource(R.string.snackbar_action)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.snackbar_title),
                style = MaterialTheme.typography.titleLarge
            )

            Button(
                onClick = {
                    showSnackbar = true
                }
            ) {
                Text(stringResource(R.string.snackbar_show))
            }
        }
    }

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            snackbarHostState.showSnackbar(
                message = snackbarMessage,
                actionLabel = snackbarAction
            )
            showSnackbar = false
        }
    }

    SnackbarHost(
        hostState = snackbarHostState,
        modifier = Modifier.fillMaxWidth(),
        snackbar = { data ->
            Snackbar(
                snackbarData = data,
                containerColor = SnackbarDefaults.color
            )
        }
    )
}

@Composable
fun SwitchSection() {
    var checked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.switch_title),
                style = MaterialTheme.typography.titleLarge
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Switch(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    colors = SwitchDefaults.colors()
                )
                Text(stringResource(R.string.switch_label))
            }
        }
    }
}

@Composable
fun TabsSection() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.tabs_title),
                style = MaterialTheme.typography.titleLarge
            )

            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = TabRowDefaults.primaryContainerColor,
                contentColor = TabRowDefaults.primaryContentColor
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) }
                    )
                }
            }

            Text("Zawartość zakładki: ${tabs[selectedTabIndex]}")
        }
    }
}

@Composable
fun TextFieldsSection() {
    var textFieldValue by remember { mutableStateOf("") }
    var outlinedTextFieldValue by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.textfield_title),
                style = MaterialTheme.typography.titleLarge
            )

            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                label = { Text("TextField") },
                placeholder = { Text("Wpisz tekst...") },
                colors = TextFieldDefaults.colors()
            )

            OutlinedTextField(
                value = outlinedTextFieldValue,
                onValueChange = { outlinedTextFieldValue = it },
                label = { Text("OutlinedTextField") },
                placeholder = { Text("Wpisz tekst...") },
                colors = TextFieldDefaults.colors()
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeInputSection() {
    val timePickerState = rememberTimePickerState(
        initialHour = LocalTime.now().hour,
        initialMinute = LocalTime.now().minute,
        is24Hour = true
    )
    var showTimePicker by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.timepicker_title),
                style = MaterialTheme.typography.titleLarge
            )

            Button(onClick = { showTimePicker = true }) {
                Text(stringResource(R.string.timepicker_show_button))
            }

            Text(
                stringResource(
                    R.string.timepicker_selected_time,
                    String.format(
                        "%02d:%02d",
                        timePickerState.hour,
                        timePickerState.minute
                    )
                )
            )

            if (showTimePicker) {
                ModalBottomSheet(
                    onDismissRequest = { showTimePicker = false }
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        TimePicker(
                            state = timePickerState,
                            colors = TimePickerDefaults.colors()
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(onClick = { showTimePicker = false }) {
                                Text(stringResource(R.string.button_cancel))
                            }
                            TextButton(onClick = { showTimePicker = false }) {
                                Text(stringResource(R.string.button_ok))
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipSection() {

    val tooltipState = rememberTooltipState(isPersistent = true)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.tooltip_title),
                style = MaterialTheme.typography.titleLarge
            )

            TooltipBox(
                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(4.dp),
                state = tooltipState,
                tooltip = {
                    PlainTooltip {
                        Text(stringResource(R.string.tooltip_example))
                    }
                }
            ) {
                Button(onClick = {}) {
                    Text("Najedź na mnie")
                }
            }
        }
    }
}

@Composable
fun FloatingActionButtonSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.fab_section_title),
                style = MaterialTheme.typography.titleLarge
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Check, contentDescription = "Add")
                }

                SmallFloatingActionButton(onClick = {}) {
                    Icon(
                        Icons.Default.Check,
                        contentDescription = "Add",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun LazyListsSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.lazy_lists_title),
                style = MaterialTheme.typography.titleLarge
            )

            Text("LazyColumn", style = MaterialTheme.typography.titleMedium)
            LazyColumn(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(5) { index ->
                    Text("Item $index")
                }
            }

            Text("LazyRow", style = MaterialTheme.typography.titleMedium)
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(5) { index ->
                    Text("Item $index", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun NavigationBarSection() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Search", "Settings")
    val icons = listOf(Icons.Default.Check, Icons.Default.Search, Icons.Default.Info)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.navigation_bar_title),
                style = MaterialTheme.typography.titleLarge
            )

            NavigationBar(
                containerColor = NavigationBarDefaults.containerColor
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors()
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.top_app_bar_title),
                style = MaterialTheme.typography.titleLarge
            )

            TopAppBar(
                title = { Text("Top App Bar") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Info, contentDescription = "Info")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors()
            )
        }
    }
}

