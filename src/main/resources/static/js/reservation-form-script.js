document.addEventListener("DOMContentLoaded", function() {
	const startInput = document.getElementById("startDate");
	const endInput = document.getElementById("endDate");

	startInput.addEventListener("change", calculateTotalPrice);
	endInput.addEventListener("change", calculateTotalPrice);

	function disableDates(input) {
		input.addEventListener("input", () => {
			const selectedDate = input.value;
			if (bookedDates.includes(selectedDate)) {
				alert("La fecha seleccionada no está disponible.");
				input.value = "";
			}
		});
	}

	disableDates(startInput);
	disableDates(endInput);

	const bookedSet = new Set(bookedDates);

	function getClosestAvailableDate(fromDate = new Date()) {
		const maxSearchDays = 365;
		for (let i = 0; i < maxSearchDays; i++) {
			const candidate = new Date(fromDate);
			candidate.setDate(candidate.getDate() + i);
			const iso = candidate.toISOString().split("T")[0];
			if (!bookedSet.has(iso)) {
				return candidate;
			}
		}
		return null;
	}

	function getSuggestedEndDate(startDate) {
		const maxRangeDays = 30;
		for (let i = 1; i < maxRangeDays; i++) {
			const nextDate = new Date(startDate);
			nextDate.setDate(startDate.getDate() + i);
			const iso = nextDate.toISOString().split("T")[0];
			if (bookedSet.has(iso)) {
				const previous = new Date(nextDate);
				previous.setDate(previous.getDate() - 1);
				return previous;
			}
		}

		const fallback = new Date(startDate);
		fallback.setDate(fallback.getDate() + 1);
		return fallback;
	}

	function calculateTotalPrice() {
		const pricePerNight = parseFloat(document.getElementById("pricePerNight").innerText.replace(/[^\d.]/g, ""));
		const start = document.getElementById("startDate").value;
		const end = document.getElementById("endDate").value;

		if (start && end) {
			const startDate = new Date(start);
			const endDate = new Date(end);

			const diffTime = endDate - startDate;
			const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));

			if (diffDays > 0) {
				const total = diffDays * pricePerNight;
				document.getElementById("totalPrice").innerText = `$${total.toFixed(2)}`;
			} else {
				document.getElementById("totalPrice").innerText = "$0.00";
			}
		}
	}

	const defaultStartDate = getClosestAvailableDate();
	const defaultEndDate = defaultStartDate ? getSuggestedEndDate(defaultStartDate) : null;

	const flatpickrStart = flatpickr("#startDate", {
		disable: bookedDates,
		dateFormat: "Y-m-d",
		minDate: "today",
		defaultDate: defaultStartDate,
		onReady: function(_, __, instance) {
			if (defaultStartDate) {
				instance.setDate(defaultStartDate, true);
			}
		},
		onChange: function(selectedDates) {
			if (selectedDates.length === 0) return;

			const selectedStart = selectedDates[0];

			const nextBlockedDate = bookedDates
				.map(dateStr => new Date(dateStr))
				.filter(date => date > selectedStart)
				.sort((a, b) => a - b)[0];

			const maxEndDate = nextBlockedDate
				? new Date(nextBlockedDate.getTime() - 86400000)
				: null;

			const suggestedEndDate = maxEndDate ?? new Date(selectedStart.getTime() + 86400000);

			flatpickrEnd.set("minDate", selectedStart);
			flatpickrEnd.set("maxDate", maxEndDate);
			flatpickrEnd.setDate(suggestedEndDate, true);
			endInput.value = suggestedEndDate.toISOString().split("T")[0];
		}
	});

	const flatpickrEnd = flatpickr("#endDate", {
		disable: bookedDates,
		dateFormat: "Y-m-d",
		minDate: "today",
		defaultDate: defaultEndDate,
		onReady: function(_, __, instance) {
			if (defaultEndDate) {
				instance.setDate(defaultEndDate, true);
				endInput.value = defaultEndDate.toISOString().split("T")[0];
			}
		}
	});

	if (defaultStartDate) {
		startInput.value = defaultStartDate.toISOString().split("T")[0];
	}
	if (defaultEndDate) {
		endInput.value = defaultEndDate.toISOString().split("T")[0];
	}
});

function changeGuest(id, delta) {
	const maxGuests = parseInt(
		document.getElementById('max-guests-limit').value, 10
	);
	const display = document.getElementById('guest-count-' + id);
	let current = parseInt(display.value, 10) || 0;
	const otherGuests = ['adults', 'childs', 'babys', 'pets']
		.filter(key => key !== id)
		.reduce((sum, key) => {
			return sum + (parseInt(
				document.getElementById('guest-count-' + key).value, 10
			) || 0);
		}, 0);

	if (delta === -1 && current > 0) {
		current--;
	}
	else if (delta === 1 && (otherGuests + current) < maxGuests) {
		current++;
	}

	display.value = current;
	const hidden = document.getElementById(id + '-input');
	if (hidden) hidden.value = current;
}

