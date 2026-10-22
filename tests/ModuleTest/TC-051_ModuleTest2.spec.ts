import { test, expect } from '@playwright/test';

test(
  'ModuleTest2',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-051' },
    tag: ['@QADENCE_TC_ID:TC-051'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step('#03 - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#04 - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step('#05 - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#06 - click', async () => {
      await page.getByRole("button", { name: "Login", exact: true }).click();
    });

    await test.step('#07 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(0).click();
    });

    await test.step('#08 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(1).click();
    });

    await test.step('#09 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(2).click();
    });

    await test.step('#10 - click', async () => {
      await page.locator('[data-test="inventory-item-description"]').locator('[data-test="inventory-item-desc"]').nth(3).click();
    });

  }
);

